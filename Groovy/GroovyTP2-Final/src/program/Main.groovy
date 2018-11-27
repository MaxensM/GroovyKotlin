package program

import groovy.json.*
import groovy.json.JsonSlurper
import groovy.json.JsonBuilder

class Main {
	
	private def reclamation
	private def couverture
	private def resultat
	private def contrat

	void calculRemboursements(){
		def jsonReclamation = reclamation
		def jsonCouverture = couverture
		contrat =  jsonReclamation.contrat
	
		if (validFile(reclamation)){
			calculEachRemboursement()
		}else{
			resultat.setText("Erreur fichier non valide")
		}
	}
	
	Boolean validFile(jsonObject){
		return (jsonObject.client.length() == 6 && jsonObject.client.matches("[0-9]+") && jsonObject.contrat.matches("[A-D]"))
	}
	
	void calculEachRemboursement() {
		
		for(each in reclamation.remboursements){
						for(each2 in couverture.Soins){
							if(matchBetweenCouvertureAndRemboursement(each2, each)){
								replaceMontantRemboursementByActualMontant(each2,each)
							}else{
								resultat.setText("Erreur un no. de soin est invalide")
							}
						}
					}
		resultat.createNewFile()
		resultat.setText(JsonOutput.prettyPrint(JsonOutput.toJson(reclamation)))
		
	}
	
	Boolean matchBetweenCouvertureAndRemboursement(each2, each) {
		return (contrat==each2.contratType && (each.soin==each2.soinId || (each.soin > 300 && each.soin <400 && each2.soinId==300)))
	}
	
	void replaceMontantRemboursementByActualMontant(each2, each) {		
		println "on a un match"
		each.montant = "" + each.montant.toBigDecimal() * each2.pourcentage/100 + ""
		println each.montant

		if (each2.maximum != null && each.montant.toBigDecimal() > each2.maximum.toBigDecimal()){
			each.montant = "" + each2.maximum + ".00"
		}
		
		if (reclamation.mois.substring(0,7)!= each.date.substring(0,7)){
			each.montant = 0.00
			}
		
			each.montant = each.montant + "\$"
	}
	
	static main(args){
		
		ImportJson input = new ImportJson()
		ExportJson output = new ExportJson('testResultat.json')
		Main mainInstance = new Main()
		
		mainInstance.reclamation = input.parseReclamation('test.json')
		mainInstance.couverture = input.parseCouverture('couverture.json')
		mainInstance.resultat = output.resultat
		
		mainInstance.calculRemboursements()
	}
	
}
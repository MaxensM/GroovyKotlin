package program

import groovy.json.JsonSlurper

class ImportJson {

	def parseReclamation(fileName){
		String inputFile = fileName
		String fileContents = new File(inputFile).getText('UTF-8')
		fileContents = fileContents.replace("\$","")
		fileContents = fileContents.replace("reclamations","remboursements")

		def jsonSlurper = new JsonSlurper()
		return jsonSlurper.parseText(fileContents)
	}

	def parseCouverture(fileName) {
		String couvertureFile = fileName
		String fileContentsCouv = new File(couvertureFile).getText('UTF-8')
		def jsonSlurperCouv = new JsonSlurper()
		return jsonSlurperCouv.parseText(fileContentsCouv)
	}
	
}


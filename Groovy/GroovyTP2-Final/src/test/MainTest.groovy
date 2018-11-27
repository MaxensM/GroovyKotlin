package test

import static org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import program.ExportJson
import program.ImportJson
import program.Main

class MainTest {
	
	Main mainInstance

	@BeforeEach
	void setUp() throws Exception {
		ImportJson input = new ImportJson()
		ExportJson output = new ExportJson('testResultat.json')
		mainInstance = new Main()
		
		mainInstance.reclamation = input.parseReclamation('test.json')
		mainInstance.couverture = input.parseCouverture('couverture.json')
		mainInstance.resultat = output.resultat
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testCalculRemboursement() {
		mainInstance.calculRemboursements()	
		assert(mainInstance.resultat != "Erreur fichier non valide")
	}
	
	@Test
	void testValidFile() {
		assert mainInstance.validFile(mainInstance.reclamation)
	}
	
	@Test
	void testCalculEachRemboursement() {
		mainInstance.calculEachRemboursement()
		assert(mainInstance.resultat != "Erreur fichier non valide")
	}

}

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

class ImportJsonTest {
	
	Main mainInstance
	ImportJson input

	@BeforeEach
	void setUp() throws Exception {
		input = new ImportJson()
		mainInstance = new Main()
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testParseReclamation() {
		assert(mainInstance.reclamation = input.parseReclamation('test.json') != null)
	}
	
	@Test
	void testParseCouverture() {
		assert(mainInstance.couverture = input.parseCouverture('couverture.json') != null)
	}


}

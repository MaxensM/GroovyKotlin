package test

import static org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import program.ExportJson

class ExportJsonTest {

	@Test
	void test() {
		ExportJson output = new ExportJson('testResultat.json')
		assert(output != null)
	}

}

package Model

import org.junit.Test

import org.junit.Assert.*
import kotlin.test.assertFails

class CouvertureTest {

    @Test
    fun montantCouvert() {
        var couverture = Couverture(1, "A", 10, 20)
        assertEquals("1.00$", couverture.MontantCouvert("10$"))
        assertEquals("2.00$", couverture.MontantCouvert("20$"))
        assertEquals("2.00$", couverture.MontantCouvert("30$"))
        assertEquals("0.00$", couverture.MontantCouvert("0$"))
        assertEquals("0.00$", couverture.MontantCouvert("-1$"))
        assertFails { couverture.MontantCouvert("") }
    }
}
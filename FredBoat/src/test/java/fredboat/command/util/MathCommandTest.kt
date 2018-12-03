package fredboat.command.util

import fredboat.testutil.IntegrationTest
import fredboat.testutil.sentinel.assertReply
import fredboat.util.TextUtils
import org.junit.jupiter.api.Test

class MathCommandTest : IntegrationTest() {
    @Test
    fun testAdd() {
        testCommand(";;math add 2 1") {
            assertReply(TextUtils.ZERO_WIDTH_CHAR + "\n" +
                    "The result is 3")
        }
    }

    @Test
    fun testSub() {
        testCommand(";;math sub 2 1") {
            assertReply(TextUtils.ZERO_WIDTH_CHAR + "\n" +
                    "The result is 1")
        }
    }

    @Test
    fun testMult() {
        testCommand(";;math mult 2 2") {
            assertReply(TextUtils.ZERO_WIDTH_CHAR + "\n" +
                    "The result is 4")
        }
    }

    @Test
    fun testDiv() {
        testCommand(";;math div 10 3") {
            assertReply(TextUtils.ZERO_WIDTH_CHAR + "\n" +
                    "The result is 3.333333333333333")
        }
    }

    @Test
    fun testMod() {
        testCommand(";;math mod 10 3") {
            assertReply(TextUtils.ZERO_WIDTH_CHAR + "\n" +
                    "The result is 1")
        }
    }

    @Test
    fun testPerc() {
        testCommand(";;math perc 25 100") {
            assertReply(TextUtils.ZERO_WIDTH_CHAR + "\n" +
                    "The result is 25%")
        }
    }

    @Test
    fun testSqrt() {
        testCommand(";;math sqrt 9") {
            assertReply(TextUtils.ZERO_WIDTH_CHAR + "\n" +
                    "The result is 3.0")
        }
    }

    @Test
    fun testPow() {
        testCommand(";;math pow 2 7") {
            assertReply(TextUtils.ZERO_WIDTH_CHAR + "\n" +
                    "The result is 128.0")
        }
    }
}
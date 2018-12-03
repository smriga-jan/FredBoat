package fredboat.command.`fun`

import fredboat.testutil.IntegrationTest
import fredboat.testutil.sentinel.assertReply
import fredboat.util.AsciiArtConstant
import fredboat.util.TextUtils
import org.junit.jupiter.api.Test

class TextCommandTest : IntegrationTest() {
    @Test
    fun testWorking() {
        testCommand(";;github") {
            assertReply(TextUtils.ZERO_WIDTH_CHAR + "\n" +
                    "https://github.com/Frederikam")
        }
    }

    @Test
    fun testAlias() {
        testCommand(";;repo") {
            assertReply(TextUtils.ZERO_WIDTH_CHAR + "\n" +
                    "https://github.com/Frederikam")
        }
    }

    @Test
    fun testDog() {
        testCommand(";;dog") {
            assertReply(TextUtils.ZERO_WIDTH_CHAR + "\n" +
                    AsciiArtConstant.DOG)
        }
    }
}
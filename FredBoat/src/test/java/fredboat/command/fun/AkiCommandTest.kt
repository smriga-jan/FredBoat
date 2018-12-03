package fredboat.command.`fun`

import fredboat.testutil.IntegrationTest
import fredboat.testutil.sentinel.assertReply
import fredboat.util.TextUtils
import org.junit.jupiter.api.Test

class AkiCommandTest : IntegrationTest() {
    @Test
    fun testWorking() {
        testCommand(";;aki") {
            assertReply(TextUtils.ZERO_WIDTH_CHAR + "\n" +
                    "\"Ahoy, the Akinator command has been discontinued on FredBoat, but you can give the Aki bot a try: https://akibot.xyz")
        }
    }
}
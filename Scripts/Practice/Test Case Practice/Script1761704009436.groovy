import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.testng.asserts.SoftAssert

SoftAssert softAssertion = new SoftAssert()

// Buka browser
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')

// Login
WebUI.setText(findTestObject('Object Repository/Page_Login/input_Username'), 'Admin')
WebUI.setEncryptedText(findTestObject('Object Repository/Page_Login/input_Password'), 'hUKwJTbofgPU9eVlw/CnDQ==') // admin123 terenkripsi
WebUI.click(findTestObject('Object Repository/Page_Login/button_Login'))

// Tunggu dashboard muncul
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Dashboard/menu_UserProfile'), 10)

// Klik profil dan logout
WebUI.click(findTestObject('Object Repository/Page_Dashboard/menu_UserProfile'))
WebUI.click(findTestObject('Object Repository/Page_Dashboard/button_Logout'))

// Screenshot hasil
WebUI.takeScreenshot('Screenshots/logout.png')

// Tutup browser
WebUI.closeBrowser()

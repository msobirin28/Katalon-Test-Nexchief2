import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://staging-chief.nexcloud.id/')

WebUI.setText(findTestObject('Object Repository/Login.NDI/Page_Nexchief/input_Selamat Datang_username'), 'sobirin_qc')

WebUI.setEncryptedText(findTestObject('Object Repository/Login.NDI/Page_Nexchief/input_Selamat Datang_password'), 'PLGTm/4mhzCFv1nCPynrvg==')s

WebUI.click(findTestObject('Object Repository/Login.NDI/Page_Nexchief/button_Masuk'))

WebUI.click(findTestObject('Object Repository/Login.NDI/Page_Nexchief/div_Login Denied'))

WebUI.click(findTestObject('Object Repository/Login.NDI/Page_Nexchief/button_Yes, Logout'))

WebUI.click(findTestObject('Object Repository/Login.NDI/Page_Nexchief/div_NDINestle Indonesia'))

WebUI.click(findTestObject('Object Repository/Login.NDI/Page_Nexchief/div'))

WebUI.click(findTestObject('Object Repository/Login.NDI/Page_Nexchief/button_Logout from Nexchief Account'))

WebUI.closeBrowser()


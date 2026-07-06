import { firefox, type FullConfig } from "@playwright/test";

async function globalSetup(config: FullConfig) {
    //Use the firefox browser
    const {baseURL, storageState} = config.projects[0].use;
    //Create the browser and page objects
    const browser = await firefox.launch();
    const page = await browser.newPage();

    //Open the landing page
    await page.goto(baseURL!);
    //Login using standard creds
    await page.getByRole('textbox', {name: "Username"}).fill('standard_user');
    await page.getByRole('textbox', {name: "Password"}).fill('secret_sauce');
    await page.getByText('Login').click();
    //Save the session info
    await page.context().storageState({path: storageState as string});

    //Await browser.close();
}

export default globalSetup;
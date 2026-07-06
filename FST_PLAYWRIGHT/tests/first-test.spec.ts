import { test, expect } from '@playwright/test';

test('has title', async ({ page }) => {
  await page.goto('https://training-support.net');

  // Expect a title "to contain" a substring.
  await expect(page).toHaveTitle("Training Support");
});

test('About us link', async ({ page }) => {
  await page.goto('https://training-support.net');

  // Click the get started link.
  await page.getByRole('link', { name: 'About Us' }).click();

  // Expects page to have a heading with the name of Installation.
  await expect(page.getByRole('heading', { name: 'About Us' })).toBeVisible();
});

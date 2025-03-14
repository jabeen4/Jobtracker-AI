package com.aiJobApplication.service;

import com.aiJobApplication.repository.JobRepository;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class JobScrapingService {

    @Autowired
    private final JobRepository jobRepository;

    public JobScrapingService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public void scrapeJobs() {
        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Open the website (Example: LinkedIn job search)
            driver.get("https://www.linkedin.com/jobs/search/?keywords=Java%20Software%20Engineer");

            // Wait for job elements to load (this might need WebDriverWait for better handling)
            Thread.sleep(5000);

            // Find job listings (Modify the XPath/CSS selector based on the actual site structure)
            List<WebElement> jobListings = driver.findElements(By.className("job-card-container"));

            for (WebElement jobElement : jobListings) {
                String title = jobElement.findElement(By.className("job-card-list__title")).getText();
                String company = jobElement.findElement(By.className("job-card-container__company-name")).getText();
                String location = jobElement.findElement(By.className("job-card-container__metadata-item")).getText();
                String jobUrl = jobElement.findElement(By.tagName("a")).getAttribute("href");

                Job job = new Job();
                job.setTitle(title);
                job.setCompany(company);
                job.setLocation(location);
                job.setUrl(jobUrl);

                jobRepository.save(job);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

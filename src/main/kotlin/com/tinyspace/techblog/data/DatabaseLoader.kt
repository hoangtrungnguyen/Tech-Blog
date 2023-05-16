package com.tinyspace.techblog.data


import com.tinyspace.techblog.data.model.Entry
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Configuration
internal class LoadDatabase {

    @Bean
    fun initDatabase(repository: EntryRepository): CommandLineRunner {
        return CommandLineRunner { args: Array<String?>? ->
            log.info("Preloading " + repository.save(Entry(1,"Bilbo Baggins", content_1, "2022-03-12", img_1, "2023-01-01")))
            log.info("Preloading " + repository.save(Entry(3,"Main HTML", content_2, "2022-03-12", img_2,
                "2023-01-01",
                type = "QUOTE")))
            log.info("Preloading " + repository.save(Entry(2,"Intellij", content_3,
                "2022-03-12", img_3, "2023-01-01", type = "IMAGE")))
        }
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(LoadDatabase::class.java)
    }
}


const val img_1 = "https://images.unsplash.com/photo-1679678691007-ae67bc760699?ixlib=rb-4.0.3&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=735&q=80"
const val img_2 = "https://images.unsplash.com/photo-1680246637339-780b4dbf1034?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80"
const val img_3 = "https://images.unsplash.com/photo-1604537529428-15bcbeecfe4d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1469&q=80"

const val content_1 = "When you render the main.html file using Thymeleaf and provide the object object with the necessary properties, the included.html file will be included, and the object's properties will be accessed and displayed accordingly.\n" +
        "\n" +
        "Make sure that the object you're passing (object in this example) is available in the Thymeleaf model or context when rendering the main.html file."


const val content_2 = "When you render the main.html file using Thymeleaf, the included.html file will be included, and the argument 'Hello, World!' will be passed to it and displayed as a heading.\n" +
        "\n" +
        "Please note that this example assumes you have properly configured Thymeleaf in your project and have the necessary dependencies set up."

const val content_3 = "\n" +
        "To include another HTML file and pass an argument to it using Thymeleaf, you can use the Thymeleaf th:include attribute and the th:with attribute.\n" +
        "\n" +
        "Assuming you have two HTML files: main.html and included.html, here's how you can include included.html into main.html and pass an argument to it:"
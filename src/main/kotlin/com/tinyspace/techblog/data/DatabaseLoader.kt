package com.tinyspace.techblog.data


import com.tinyspace.techblog.controller.dateFromString
import com.tinyspace.techblog.data.model.Entry
import com.tinyspace.techblog.data.model.Owner
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.time.Instant
import java.util.*

@Configuration
internal class LoadDatabase {

    @Bean
    fun initDatabase(repository: EntryRepository, ownerRepository: OwnerRepository): CommandLineRunner {
        return CommandLineRunner { args: Array<String?>? ->
            log.info("Preloading " + repository.save(Entry(1,"Bilbo Baggins", content_1, Date(), img_1, "2023-01-01".dateFromString())))
            log.info("Preloading " + repository.save(Entry(3,"Main HTML", content_2,  Date(), img_2,
                Date(),
                type = "QUOTE")))
            log.info("Preloading " + repository.save(Entry(2,"Intellij", content_3,
               "2022-03-12".dateFromString(), img_3, "2022-01-01".dateFromString(), type = "IMAGE")))
            log.info("Preloading " + ownerRepository.save(Owner(1, "Han Sara", u_intro)))
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

const val u_intro =  "Lorem Ipsum s simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
        "\nLorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
        "\nLorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
        "\nLorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
        "\nLorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
        "\n"
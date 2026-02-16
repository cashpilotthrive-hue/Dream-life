package org.jetbrains.plugins.template.services

import com.intellij.openapi.components.Service
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.project.Project
import org.jetbrains.plugins.template.MyBundle

@Service(Service.Level.PROJECT)
class MyProjectService(project: Project) {

    private val motivationalQuotes = listOf(
        "The future belongs to those who believe in the beauty of their dreams. - Eleanor Roosevelt",
        "Dream big and dare to fail. - Norman Vaughan",
        "Don't watch the clock; do what it does. Keep going. - Sam Levenson",
        "The only way to do great work is to love what you do. - Steve Jobs",
        "Believe you can and you're halfway there. - Theodore Roosevelt",
        "Success is not final, failure is not fatal: It is the courage to continue that counts. - Winston Churchill",
        "Your time is limited, don't waste it living someone else's life. - Steve Jobs",
        "The only impossible journey is the one you never begin. - Tony Robbins",
        "Everything you've ever wanted is on the other side of fear. - George Addair",
        "Dream as if you'll live forever, live as if you'll die today. - James Dean",
        "The biggest adventure you can take is to live the life of your dreams. - Oprah Winfrey",
        "Go confidently in the direction of your dreams! Live the life you've imagined. - Henry David Thoreau",
        "Twenty years from now you will be more disappointed by the things you didn't do. - Mark Twain",
        "It does not matter how slowly you go as long as you do not stop. - Confucius",
        "A person who never made a mistake never tried anything new. - Albert Einstein"
    )

    init {
        thisLogger().info(MyBundle.message("projectService", project.name))
    }

    fun getRandomQuote() = motivationalQuotes.random()
}

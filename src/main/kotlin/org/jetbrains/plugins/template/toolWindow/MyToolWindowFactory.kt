package org.jetbrains.plugins.template.toolWindow

import com.intellij.openapi.components.service
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBPanel
import com.intellij.ui.content.ContentFactory
import org.jetbrains.plugins.template.MyBundle
import org.jetbrains.plugins.template.services.MyProjectService
import java.awt.BorderLayout
import java.awt.Font
import javax.swing.JButton
import javax.swing.JTextArea
import javax.swing.border.EmptyBorder


class MyToolWindowFactory : ToolWindowFactory {

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val myToolWindow = MyToolWindow(toolWindow)
        val content = ContentFactory.getInstance().createContent(myToolWindow.getContent(), null, false)
        toolWindow.contentManager.addContent(content)
    }

    override fun shouldBeAvailable(project: Project) = true

    class MyToolWindow(toolWindow: ToolWindow) {

        private val service = toolWindow.project.service<MyProjectService>()

        fun getContent() = JBPanel<JBPanel<*>>().apply {
            layout = BorderLayout(10, 10)
            border = EmptyBorder(20, 20, 20, 20)
            
            val titleLabel = JBLabel(MyBundle.message("dreamlife.title")).apply {
                font = font.deriveFont(Font.BOLD, 18f)
            }
            
            val quoteArea = JTextArea(MyBundle.message("dreamlife.welcome")).apply {
                isEditable = false
                lineWrap = true
                wrapStyleWord = true
                font = font.deriveFont(14f)
                rows = 6
                background = null
            }

            val buttonPanel = JBPanel<JBPanel<*>>().apply {
                add(JButton(MyBundle.message("dreamlife.inspire")).apply {
                    addActionListener {
                        quoteArea.text = service.getRandomQuote()
                    }
                })
            }
            
            add(titleLabel, BorderLayout.NORTH)
            add(quoteArea, BorderLayout.CENTER)
            add(buttonPanel, BorderLayout.SOUTH)
        }
    }
}

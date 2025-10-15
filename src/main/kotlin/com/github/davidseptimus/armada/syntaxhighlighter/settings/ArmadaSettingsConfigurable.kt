package com.github.davidseptimus.armada.syntaxhighlighter.settings

import com.github.davidseptimus.armada.syntaxhighlighter.settings.ArmadaSyntaxHighlighterBundle.message
import com.intellij.openapi.options.Configurable
import com.intellij.ui.components.JBCheckBox
import com.intellij.ui.components.JBLabel
import com.intellij.util.ui.FormBuilder
import javax.swing.JComponent
import javax.swing.JPanel

class ArmadaSettingsConfigurable : Configurable {

    private var disableSyntaxHighlightingCheckBox: JBCheckBox? = null
    private var enableForAllThemesCheckBox: JBCheckBox? = null
    private var mainPanel: JPanel? = null

    override fun getDisplayName(): String = message("settings.displayName")

    override fun createComponent(): JComponent {
        val description1 = JBLabel(
            "<html>${message("settings.description.enhancements")}</html>"
        )

        val description2 = JBLabel(message("settings.description.defaultBehavior"))

        disableSyntaxHighlightingCheckBox = JBCheckBox(message("settings.checkbox.disable"))
        enableForAllThemesCheckBox = JBCheckBox(message("settings.checkbox.enableForAll"))

        disableSyntaxHighlightingCheckBox?.addChangeListener {
            enableForAllThemesCheckBox?.isEnabled = !disableSyntaxHighlightingCheckBox!!.isSelected
        }

        mainPanel = FormBuilder.createFormBuilder()
            .addComponent(description1)
            .addVerticalGap(6)
            .addComponent(description2)
            .addVerticalGap(10)
            .addComponent(disableSyntaxHighlightingCheckBox!!)
            .addComponent(enableForAllThemesCheckBox!!)
            .addComponentFillVertically(JPanel(), 0)
            .panel

        return mainPanel!!
    }

    override fun isModified(): Boolean {
        val settings = ArmadaSettingsState.instance
        return disableSyntaxHighlightingCheckBox?.isSelected != settings.disableSyntaxHighlighting ||
                enableForAllThemesCheckBox?.isSelected != settings.enableForAllThemes
    }

    override fun apply() {
        val settings = ArmadaSettingsState.instance
        settings.disableSyntaxHighlighting = disableSyntaxHighlightingCheckBox?.isSelected ?: false
        settings.enableForAllThemes = enableForAllThemesCheckBox?.isSelected ?: false

        // Notify controller to recalculate annotation state
        ArmadaAnnotationController.instance.onSettingsChanged()
    }

    override fun reset() {
        val settings = ArmadaSettingsState.instance
        disableSyntaxHighlightingCheckBox?.isSelected = settings.disableSyntaxHighlighting
        enableForAllThemesCheckBox?.isSelected = settings.enableForAllThemes
        enableForAllThemesCheckBox?.isEnabled = !settings.disableSyntaxHighlighting
    }

    override fun disposeUIResources() {
        disableSyntaxHighlightingCheckBox = null
        enableForAllThemesCheckBox = null
    }
}
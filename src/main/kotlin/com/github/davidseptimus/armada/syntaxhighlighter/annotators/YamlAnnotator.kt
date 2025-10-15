package com.github.davidseptimus.armada.syntaxhighlighter.annotators

import com.github.davidseptimus.armada.syntaxhighlighter.settings.TextAttributeKeys
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiElement
import org.jetbrains.yaml.psi.YAMLAlias
import org.jetbrains.yaml.psi.YAMLScalar

class YamlAnnotator : BaseArmadaAnnotator() {

    override fun doAnnotate(element: PsiElement, holder: AnnotationHolder) {
        when {
            // Highlight aliases (e.g., *params)
            element is YAMLAlias -> {
                highlightElement(element, holder, TextAttributeKeys.YAML_ALIAS)
            }

            element is YAMLScalar -> {
                // Check if the scalar value is a builtin (boolean or null)
                val text = element.text
                if (text in BUILTIN_VALUES) {
                    highlightElement(element, holder, TextAttributeKeys.YAML_BUILTIN)
                }
            }
        }
    }
}

// YAML boolean and null values according to YAML 1.2 spec
private val BUILTIN_VALUES = setOf(
    "true", "True", "TRUE",
    "false", "False", "FALSE",
    "~", "null", "Null", "NULL"
)
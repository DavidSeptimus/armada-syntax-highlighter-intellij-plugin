package com.github.davidseptimus.armada.syntaxhighlighter.annotators

import com.github.davidseptimus.armada.syntaxhighlighter.settings.TextAttributeKeys
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.JavaTokenType
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType

class JavaAnnotator : BaseArmadaAnnotator() {

    override fun doAnnotate(element: PsiElement, holder: AnnotationHolder) {
        if (annotateAnnotationDeclaration(element, holder)) return
    }

    private fun annotateAnnotationDeclaration(element: PsiElement, holder: AnnotationHolder): Boolean {
        if (element.elementType == JavaTokenType.AT && element.parent is PsiClass && (element.parent as PsiClass).isAnnotationType) {
            highlightElement(element, holder, TextAttributeKeys.JAVA_ANNOTATION_DECLARATION)
            return true
        }
        return false
    }
}
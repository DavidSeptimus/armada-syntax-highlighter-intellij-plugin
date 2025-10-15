package com.github.davidseptimus.armada.syntaxhighlighter.annotators

import com.github.davidseptimus.armada.syntaxhighlighter.settings.TextAttributeKeys
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.javascript.JSTokenTypes
import com.intellij.lang.javascript.psi.JSFunction
import com.intellij.lang.javascript.psi.JSFunctionExpression
import com.intellij.lang.javascript.psi.JSThisExpression
import com.intellij.lang.javascript.psi.JSVariable
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType


class JavaScriptAnnotator : BaseArmadaAnnotator() {

    override fun doAnnotate(element: PsiElement, holder: AnnotationHolder) {
        annotateThisIdentifier(element, holder)
        annotateFunctionDeclaration(element, holder)
    }

    private fun annotateFunctionDeclaration(
        element: PsiElement,
        holder: AnnotationHolder
    ) {
        if (element.elementType != JSTokenTypes.IDENTIFIER) {
            return
        }

        if (element.parent is JSFunction
            || element.parent is JSVariable && hasSibling(element, JSFunctionExpression::class.java)
        ) {
            highlightElement(element, holder, TextAttributeKeys.JAVASCRIPT_FUNCTION_DECLARATION_IDENTIFIER)
        }
    }

    private fun annotateThisIdentifier(element: PsiElement, holder: AnnotationHolder) {
        if (element is JSThisExpression) {
            highlightElement(element, holder, TextAttributeKeys.JAVASCRIPT_THIS_IDENTIFIER)
        }
    }
}

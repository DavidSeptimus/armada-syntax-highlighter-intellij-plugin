package com.github.davidseptimus.armada.syntaxhighlighter.annotators

import com.github.davidseptimus.armada.syntaxhighlighter.settings.TextAttributeKeys
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import org.rust.lang.core.psi.*


class RustAnnotator : BaseArmadaAnnotator() {
    val attributePunctuation = setOf("#", "!", "[", "]", "(", ")", ",", "=")

    override fun doAnnotate(element: PsiElement, holder: AnnotationHolder) {
       if  (annotateMetadata(element, holder)) return
        annotateBooleanLiteral(element, holder)
    }

    private fun annotateBooleanLiteral(
        element: PsiElement,
        holder: AnnotationHolder
    ): Boolean {
        if (element.elementType == RsElementTypes.BOOL_LITERAL) {
            highlightElement(element, holder, TextAttributeKeys.RUST_BOOLEAN)
            return true
        }
        return false
    }


    private fun annotateMetadata(element: PsiElement, holder: AnnotationHolder): Boolean {
        when {
            attributePunctuation.contains(element.text) && (element.parent is RsOuterAttr || element.parent is RsInnerAttr || element.parent is RsMetaItemArgs || element.parent is RsMetaItem ) -> {
                highlightElement(element, holder, TextAttributeKeys.RUST_ATTRIBUTE_PUNCTUATION)
                return true
            }
        }
        return false
    }
}

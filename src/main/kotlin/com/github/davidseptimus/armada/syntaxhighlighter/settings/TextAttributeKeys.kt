package com.github.davidseptimus.armada.syntaxhighlighter.settings

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.sql.editor.SqlColors

object TextAttributeKeys {
    val CSS_IDENTIFIER_TERM: TextAttributesKey = TextAttributesKey.createTextAttributesKey("CSS.TERM_IDENTIFIER")
    val CSS_PERCENT: TextAttributesKey = TextAttributesKey.createTextAttributesKey("CSS.PERCENT")
    val JAVA_ANNOTATION_DECLARATION: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "JAVA.ANNOTATION_DECLARATION",
        DefaultLanguageHighlighterColors.METADATA
    )
    val JAVASCRIPT_FUNCTION_DECLARATION_IDENTIFIER: TextAttributesKey =
        TextAttributesKey.createTextAttributesKey("JS.FUNCTION_DECLARATION_IDENTIFIER")
    val JAVASCRIPT_THIS_IDENTIFIER: TextAttributesKey = TextAttributesKey.createTextAttributesKey("JS.THIS_IDENTIFIER")
    val KOTLIN_LABEL_AT: TextAttributesKey = TextAttributesKey.createTextAttributesKey("KOTLIN_LABEL_AT")
    val PHP_CLASS_REFERENCE: TextAttributesKey = TextAttributesKey.createTextAttributesKey("PHP_CLASS_REFERENCE")
    val PHP_ALIAS_IDENTIFIER_DECLARATION: TextAttributesKey =
        TextAttributesKey.createTextAttributesKey("PHP_ALIAS_IDENTIFIER_DECLARATION")
    val PHP_CLASS_SELF_REFERENCE: TextAttributesKey =
        TextAttributesKey.createTextAttributesKey("PHP_CLASS_SELF_REFERENCE")
    val PHP_GOTO_LABEL_IDENTIFIER: TextAttributesKey =
        TextAttributesKey.createTextAttributesKey("PHP_GOTO_LABEL_IDENTIFIER")
    val PROPERTIES_STRING_LITERAL_VALUE: TextAttributesKey =
        TextAttributesKey.createTextAttributesKey("PROPERTIES.STRING_LITERAL_VALUE")
    val PYTHON_TYPE_ANNOTATION: TextAttributesKey = TextAttributesKey.createTextAttributesKey("PY.TYPE_ANNOTATION")

    // PYTHON_TYPE_PARAMETER is an existing attribute, but doesn't seem to get highlighted by the python highlighter
    val PYTHON_TYPE_PARAMETER: TextAttributesKey = TextAttributesKey.createTextAttributesKey("PY.TYPE_PARAMETER")
    val XML_DOCTYPE: TextAttributesKey = TextAttributesKey.createTextAttributesKey("XML_DOCTYPE")
    val YAML_ALIAS: TextAttributesKey = TextAttributesKey.createTextAttributesKey("YAML_ALIAS")
    val YAML_BUILTIN: TextAttributesKey =
        TextAttributesKey.createTextAttributesKey("YAML_BUILTIN", DefaultLanguageHighlighterColors.KEYWORD)
    val ZIG_FIELD_TYPE: TextAttributesKey = TextAttributesKey.createTextAttributesKey("ZIG_FIELD_TYPE")
    val ZIG_RETURN_TYPE_IDENTIFIER: TextAttributesKey =
        TextAttributesKey.createTextAttributesKey("ZIG_RETURN_TYPE_IDENTIFIER", ZIG_FIELD_TYPE)
    val BASH_LET_COMMAND: TextAttributesKey = TextAttributesKey.createTextAttributesKey("BASH.LET_COMMAND")
    val BASH_SUBSHELL_COMMAND_PARENTHESES: TextAttributesKey =
        TextAttributesKey.createTextAttributesKey("BASH.SUBSHELL_COMMAND_PARENTHESES")
    val RUST_ATTRIBUTE_PUNCTUATION: TextAttributesKey =
        TextAttributesKey.createTextAttributesKey("org.rust.ATTRIBUTE_PUNCTUATION")
    val RUST_BOOLEAN: TextAttributesKey = TextAttributesKey.createTextAttributesKey("org.rust.BOOLEAN")
    val SQL_REFERENCE_IDENTIFIER: TextAttributesKey =
        TextAttributesKey.createTextAttributesKey("SQL_REFERENCE_IDENTIFIER")
    val SQL_PRIMARY_KEY_DEFINITION: TextAttributesKey =
        TextAttributesKey.createTextAttributesKey("SQL_PRIMARY_KEY_DEFINITION")
    val SQL_SYMBOLIC_OPERATORS: TextAttributesKey =
        TextAttributesKey.createTextAttributesKey("SQL_SYMBOLIC_OPERATORS", SqlColors.SQL_KEYWORD)
    val SQL_FOREIGN_KEY_DEFINITION: TextAttributesKey =
        TextAttributesKey.createTextAttributesKey("SQL_FOREIGN_KEY_DEFINITION", SQL_PRIMARY_KEY_DEFINITION)
    val SQL_SCHEMA_TABLE_IDENTIFIER: TextAttributesKey =
        TextAttributesKey.createTextAttributesKey("SQL_SCHEMA_TABLE_IDENTIFIER")
}
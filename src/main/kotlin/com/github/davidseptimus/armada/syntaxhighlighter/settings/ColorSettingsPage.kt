package com.github.davidseptimus.armada.syntaxhighlighter.settings

import com.github.davidseptimus.armada.syntaxhighlighter.ArmadaSyntaxHighlighterBundle.message
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.PlainSyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import org.jetbrains.annotations.NonNls
import java.util.Map
import javax.swing.Icon

internal class ArmadaColorSettingsPage : ColorSettingsPage {
    override fun getIcon(): Icon? {
        return null
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return PlainSyntaxHighlighter()
    }

    @NonNls
    override fun getDemoText(): String {
        return """
                <comment>// CSS</comment>
                color: <css_identifier>--someColor</css_identifier>; <comment>// CSS Identifier Term</comment>
                width: <css_percent>100%</css_percent>; <comment>// CSS Percent</comment>

                <comment>// Java</comment>
                <java_annotation>@</java_annotation>interface MyAnnotation {} <comment>// Java Annotation Declaration @</comment>

                <comment>// JavaScript</comment>
                function <js_function_decl>myFunc</js_function_decl>() {} <comment>// JavaScript Function Declaration Identifier</comment>
                <js_this>this</js_this> <comment>// JavaScript This Identifier</comment>

                <comment>// PHP</comment>
                use SomeType as <php_alias>MyType</php_alias>; <comment>// PHP Alias Identifier Declaration</comment>
                ${'$'}def .=  <php_self>self</php_self>::magic; <comment>// PHP Class Self Reference</comment>
                A extends <php_class>B</php_class> implements <php_class>C</php_class>; <comment>// PHP Class Reference</comment>
                goto <php_label>SomeLabel</php_label>; <comment>// PHP Goto Label Identifier</comment>

                <comment>// Properties</comment>
                a = <properties_string>"b"</properties_string> <comment>// Properties String Literal Value</comment>

                <comment>// Python</comment>
                def my_func(arg1: <python_type>MyType</python_type>) -> <python_type>None</python_type>: <comment>// Python Type Annotation</comment>
                    pass

                <comment>// Rust</comment>
                <rust_attr>#</rust_attr><rust_attr>!</rust_attr><rust_attr>[</rust_attr>some_attribute = "value"<rust_attr>]</rust_attr>  <comment>// Rust Attribute Punctuation</comment>
                let is_enabled: bool = <rust_boolean>true</rust_boolean>; <comment>// Rust Boolean</comment>

                <comment>// Shell Script</comment>
                <bash_let>let</bash_let> a=5 b=10 <comment>// Shell Script let command</comment>
                rm -f <bash_subshell>${'$'}</bash_subshell><bash_subshell>(</bash_subshell>find / -name core<bash_subshell>)</bash_subshell> <comment>// Shell Script Subshell Command Parentheses</comment>
                <comment>// XML</comment>
                <xml_doctype><!DOCTYPE html></xml_doctype> <comment>// XML DocType</comment>

                <comment>// SQL</comment>
                alter table orders add constraint fk_customer <sql_foreign_key>foreign key</sql_foreign_key> (customer_id) <sql_foreign_key>references</sql_foreign_key> customers(id); <comment>// SQL Foreign Key Definition</comment>
                create table users (id int <sql_primary_key>primary key</sql_primary_key>, name varchar(100)); <comment>// SQL Primary Key Definition</comment>
                select <sql_symbolic>*</sql_symbolic> from users where id <sql_symbolic>=</sql_symbolic> 5; <comment>// SQL symbolic Operators</comment>
                select id from <sql_reference>crm</sql_reference>.<sql_reference>product</sql_reference>; <comment>// SQL Table Reference Identifier</comment>
                create table <sql_schema_table>my_table</sql_schema_table> (id int, name varchar(100)); <comment>// SQL Schema Table Identifier</comment>

                <comment>// YAML</comment>
                a: <yaml_alias>*alias</yaml_alias> <comment>// YAML Alias</comment>
                b: <yaml_builtin>true</yaml_builtin> <yaml_builtin>~</yaml_builtin> <comment>// YAML Builtin</comment>

                <comment>// Zig</comment>
                field: <zig_field>?*Node</zig_field> <comment>// Zig Field/Argument Type</comment>
                pub fn myFunc() <zig_return>SomeError.Variant!void</zig_return> { <comment>// Zig Return Type Identifier</comment>
                    return null;
                }
                
                """.trimIndent()
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey> {
        return Map.ofEntries<String, TextAttributesKey>(
            Map.entry<String, TextAttributesKey>("comment", DefaultLanguageHighlighterColors.LINE_COMMENT),
            Map.entry<String, TextAttributesKey>("css_identifier", TextAttributeKeys.CSS_IDENTIFIER_TERM),
            Map.entry<String, TextAttributesKey>("css_percent", TextAttributeKeys.CSS_PERCENT),
            Map.entry<String, TextAttributesKey>("java_annotation", TextAttributeKeys.JAVA_ANNOTATION_DECLARATION),
            Map.entry<String, TextAttributesKey>(
                "js_function_decl",
                TextAttributeKeys.JAVASCRIPT_FUNCTION_DECLARATION_IDENTIFIER
            ),
            Map.entry<String, TextAttributesKey>("js_this", TextAttributeKeys.JAVASCRIPT_THIS_IDENTIFIER),
            Map.entry<String, TextAttributesKey>("php_alias", TextAttributeKeys.PHP_ALIAS_IDENTIFIER_DECLARATION),
            Map.entry<String, TextAttributesKey>("php_class", TextAttributeKeys.PHP_CLASS_REFERENCE),
            Map.entry<String, TextAttributesKey>("php_self", TextAttributeKeys.PHP_CLASS_SELF_REFERENCE),
            Map.entry<String, TextAttributesKey>("php_label", TextAttributeKeys.PHP_GOTO_LABEL_IDENTIFIER),
            Map.entry<String, TextAttributesKey>(
                "properties_string",
                TextAttributeKeys.PROPERTIES_STRING_LITERAL_VALUE
            ),
            Map.entry<String, TextAttributesKey>("python_type", TextAttributeKeys.PYTHON_TYPE_ANNOTATION),
            Map.entry<String, TextAttributesKey>("rust_attr", TextAttributeKeys.RUST_ATTRIBUTE_PUNCTUATION),
            Map.entry<String, TextAttributesKey>("rust_boolean", TextAttributeKeys.RUST_BOOLEAN),
            Map.entry<String, TextAttributesKey>("bash_let", TextAttributeKeys.BASH_LET_COMMAND),
            Map.entry<String, TextAttributesKey>("bash_subshell", TextAttributeKeys.BASH_SUBSHELL_COMMAND_PARENTHESES),
            Map.entry<String, TextAttributesKey>("sql_symbolic", TextAttributeKeys.SQL_SYMBOLIC_OPERATORS),
            Map.entry<String, TextAttributesKey>("sql_foreign_key", TextAttributeKeys.SQL_FOREIGN_KEY_DEFINITION),
            Map.entry<String, TextAttributesKey>("sql_primary_key", TextAttributeKeys.SQL_PRIMARY_KEY_DEFINITION),
            Map.entry<String, TextAttributesKey>("sql_reference", TextAttributeKeys.SQL_REFERENCE_IDENTIFIER),
            Map.entry<String, TextAttributesKey>("sql_schema_table", TextAttributeKeys.SQL_SCHEMA_TABLE_IDENTIFIER),
            Map.entry<String, TextAttributesKey>("xml_doctype", TextAttributeKeys.XML_DOCTYPE),
            Map.entry<String, TextAttributesKey>("yaml_alias", TextAttributeKeys.YAML_ALIAS),
            Map.entry<String, TextAttributesKey>("yaml_builtin", TextAttributeKeys.YAML_BUILTIN),
            Map.entry<String, TextAttributesKey>("zig_field", TextAttributeKeys.ZIG_FIELD_TYPE),
            Map.entry<String, TextAttributesKey>("zig_return", TextAttributeKeys.ZIG_RETURN_TYPE_IDENTIFIER)
        )
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS
    }

    override fun getColorDescriptors(): Array<ColorDescriptor?> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getDisplayName(): String {
        return message("colorSettings.displayName")
    }

}

private val DESCRIPTORS: Array<AttributesDescriptor> = arrayOf(
    AttributesDescriptor(message("colorSettings.css.percent"), TextAttributeKeys.CSS_PERCENT),
    AttributesDescriptor(message("colorSettings.css.identifierTerm"), TextAttributeKeys.CSS_IDENTIFIER_TERM),
    AttributesDescriptor(
        message("colorSettings.java.annotationDeclaration"),
        TextAttributeKeys.JAVA_ANNOTATION_DECLARATION
    ),
    AttributesDescriptor(
        message("colorSettings.javascript.functionDeclarationIdentifier"),
        TextAttributeKeys.JAVASCRIPT_FUNCTION_DECLARATION_IDENTIFIER
    ),
    AttributesDescriptor(
        message("colorSettings.javascript.thisIdentifier"),
        TextAttributeKeys.JAVASCRIPT_THIS_IDENTIFIER
    ),
    AttributesDescriptor(
        message("colorSettings.php.aliasIdentifierDeclaration"),
        TextAttributeKeys.PHP_ALIAS_IDENTIFIER_DECLARATION
    ),
    AttributesDescriptor(message("colorSettings.php.classReference"), TextAttributeKeys.PHP_CLASS_REFERENCE),
    AttributesDescriptor(
        message("colorSettings.php.classSelfReference"),
        TextAttributeKeys.PHP_CLASS_SELF_REFERENCE
    ),
    AttributesDescriptor(
        message("colorSettings.php.gotoLabelIdentifier"),
        TextAttributeKeys.PHP_GOTO_LABEL_IDENTIFIER
    ),
    AttributesDescriptor(
        message("colorSettings.properties.stringLiteralValue"),
        TextAttributeKeys.PROPERTIES_STRING_LITERAL_VALUE
    ),
    AttributesDescriptor(
        message("colorSettings.python.typeAnnotation"),
        TextAttributeKeys.PYTHON_TYPE_ANNOTATION
    ),
    AttributesDescriptor(
        message("colorSettings.rust.attributePunctuation"),
        TextAttributeKeys.RUST_ATTRIBUTE_PUNCTUATION
    ),
    AttributesDescriptor(message("colorSettings.rust.boolean"), TextAttributeKeys.RUST_BOOLEAN),
    AttributesDescriptor(message("colorSettings.shell.letCommand"), TextAttributeKeys.BASH_LET_COMMAND),
    AttributesDescriptor(
        message("colorSettings.shell.subshellCommandParentheses"),
        TextAttributeKeys.BASH_SUBSHELL_COMMAND_PARENTHESES
    ),
    AttributesDescriptor(
        message("colorSettings.sql.symbolicOperators"),
        TextAttributeKeys.SQL_SYMBOLIC_OPERATORS
    ),
    AttributesDescriptor(
        message("colorSettings.sql.foreignKeyDefinition"),
        TextAttributeKeys.SQL_FOREIGN_KEY_DEFINITION
    ),
    AttributesDescriptor(
        message("colorSettings.sql.primaryKeyDefinition"),
        TextAttributeKeys.SQL_PRIMARY_KEY_DEFINITION
    ),
    AttributesDescriptor(
        message("colorSettings.sql.referenceIdentifier"),
        TextAttributeKeys.SQL_REFERENCE_IDENTIFIER
    ),
    AttributesDescriptor(
        message("colorSettings.sql.schemaTableIdentifier"),
        TextAttributeKeys.SQL_SCHEMA_TABLE_IDENTIFIER
    ),
    AttributesDescriptor(message("colorSettings.xml.doctype"), TextAttributeKeys.XML_DOCTYPE),
    AttributesDescriptor(message("colorSettings.yaml.alias"), TextAttributeKeys.YAML_ALIAS),
    AttributesDescriptor(message("colorSettings.yaml.builtin"), TextAttributeKeys.YAML_BUILTIN),
    AttributesDescriptor(message("colorSettings.zig.fieldType"), TextAttributeKeys.ZIG_FIELD_TYPE),
    AttributesDescriptor(
        message("colorSettings.zig.returnTypeIdentifier"),
        TextAttributeKeys.ZIG_RETURN_TYPE_IDENTIFIER
    ),
)
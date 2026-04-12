package com.github.davidseptimus.armada.syntaxhighlighter.textmate

import com.intellij.openapi.application.PathManager
import com.intellij.openapi.diagnostic.thisLogger
import org.jetbrains.plugins.textmate.api.TextMateBundleProvider
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

/**
 * Ships a small TextMate bundle that registers more-specific log.* scopes so that each
 * Armada color scheme can override the TextMateCustomRule_log.* keys without affecting
 * the DIFF_INSERTED/DIFF_DELETED/DIFF_MODIFIED keys used elsewhere in the platform.
 *
 * The bundle itself carries no colors — the scope registration alone creates the hook.
 * Actual colors come from each Armada scheme XML; non-Armada schemes are unaffected.
 */
class ArmadaLogBundleProvider : TextMateBundleProvider {
    override fun getBundles(): List<TextMateBundleProvider.PluginBundle> {
        val path = extractBundle() ?: return emptyList()
        return listOf(TextMateBundleProvider.PluginBundle(BUNDLE_NAME, path))
    }

    private fun extractBundle(): Path? {
        val targetDir = Paths.get(PathManager.getSystemPath(), "armada", "textmate-bundles", BUNDLE_NAME)
        return try {
            Files.createDirectories(targetDir)
            for (relative in BUNDLE_FILES) {
                val target = targetDir.resolve(relative)
                Files.createDirectories(target.parent)
                val resource = "$BUNDLE_RESOURCE_ROOT/$relative"
                val stream = javaClass.getResourceAsStream(resource) ?: run {
                    thisLogger().warn("Missing TextMate bundle resource: $resource")
                    return null
                }
                stream.use { Files.copy(it, target, StandardCopyOption.REPLACE_EXISTING) }
            }
            targetDir
        } catch (e: Exception) {
            thisLogger().warn("Failed to extract Armada log bundle", e)
            null
        }
    }

    private companion object {
        const val BUNDLE_NAME = "armada-log"
        const val BUNDLE_RESOURCE_ROOT = "/textmate-bundles/armada-log"
        val BUNDLE_FILES = listOf(
            "info.plist",
            "Preferences/log-info.tmPreferences",
            "Preferences/log-warning.tmPreferences",
            "Preferences/log-error.tmPreferences",
            "Preferences/log-debug.tmPreferences",
            "Preferences/log-verbose.tmPreferences",
        )
    }
}

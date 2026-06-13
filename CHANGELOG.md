<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# Armada Syntax Highlighter Changelog

## [Unreleased]

### Changed

- Increased maximum supported IDE version to `261.*`

### Removed

- Removed * from yaml alias highligt

### Fixed

- No longer bundles the Kotlin standard library; the IDE-provided stdlib is used instead, avoiding classloader conflicts with the platform and with other plugins (a stale bundled stdlib could shadow the platform's and break coroutine debug probes on 2026.1)

## [1.0.0] - 2025-10-20

### Added

- Added YAML boolean and null value annotation

### Removed

- Removed JavaScript property reference annotation
- Removed Kotlin label annotation

### Fixed

- Dependency on potentially unavailable plugins when used outside IntelliJ IDEA Ultimate Edition

### Changed

- Migrated syntax highlighting to a dedicated plugin to allow for independent updates and improvements
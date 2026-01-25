<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# Armada Syntax Highlighter Changelog

## [Unreleased]

### Changed

- Increased maximum supported IDE version to `261.*`

### Removed

- Removed * from yaml alias highligt

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
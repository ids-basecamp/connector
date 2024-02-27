/*
 *  Copyright (c) 2023 Microsoft Corporation
 *
 *  This program and the accompanying materials are made available under the
 *  terms of the Apache License, Version 2.0 which is available at
 *  https://www.apache.org/licenses/LICENSE-2.0
 *
 *  SPDX-License-Identifier: Apache-2.0
 *
 *  Contributors:
 *       Microsoft Corporation - Initial implementation
 *       truzzt GmbH - EDC extension implementation
 *
 */

dependencyResolutionManagement {
    repositories {
        val user = providers.gradleProperty("gitHubUserName")
        val token = providers.gradleProperty("gitHubUserPassword")
        maven {
            url = uri("https://maven.pkg.github.com/ids-basecamp/gradle-plugins-fork")
            credentials {
                username = user.orNull
                password = token.orNull
            }
        }
        maven {
            url = uri("https://maven.pkg.github.com/ids-basecamp/edc-fork")
            credentials {
                username = user.orNull
                password = token.orNull
            }
        }
        maven {
            url = uri("https://maven.pkg.github.com/ids-basecamp/edc-extensions-fork")
            credentials {
                username = user.orNull
                password = token.orNull
            }
        }
        mavenCentral()
        mavenLocal()
    }
    versionCatalogs {
        val gradlePluginsGroup = providers.gradleProperty("gradlePluginsGroup")
        val gradlePluginsVersion = providers.gradleProperty("gradlePluginsVersion")
        create("libs") {
            from(gradlePluginsGroup.get() + ":edc-versions:" + gradlePluginsVersion.get())
        }

        val edcGroup = providers.gradleProperty("edcGroup")
        val edcVersion = providers.gradleProperty("edcVersion")
        create("edc") {
            version("edc", edcVersion.get())

            library("boot", edcGroup.get(), "boot").versionRef("edc")
            library("core-connector", edcGroup.get(), "connector-core").versionRef("edc")
            library("core-jersey", edcGroup.get(), "jersey-core").versionRef("edc")
            library("core-controlplane", edcGroup.get(), "control-plane-core").versionRef("edc")
            library("api-observability", edcGroup.get(), "api-observability").versionRef("edc")

            library("spi-ids", edcGroup.get(), "ids-spi").versionRef("edc")
            library("ids", edcGroup.get(), "ids").versionRef("edc")
            library("ids-jsonld-serdes", edcGroup.get(), "ids-jsonld-serdes").versionRef("edc")

            library("api-management", edcGroup.get(), "management-api").versionRef("edc")
            library("config-filesystem", edcGroup.get(), "configuration-filesystem").versionRef("edc")
            library("oauth2-core", edcGroup.get(), "oauth2-core").versionRef("edc")
            library("iam-mock", edcGroup.get(), "iam-mock").versionRef("edc")
            library("vault-filesystem", edcGroup.get(), "vault-filesystem").versionRef("edc")

            // Data Plane
            library("dpf-core", edcGroup.get(), "data-plane-core").versionRef("edc")
            library("dpf-selector-core", edcGroup.get(), "data-plane-selector-core").versionRef("edc")
            library("dpf-selector-client", edcGroup.get(), "data-plane-selector-client").versionRef("edc")
            library("dpf-framework", edcGroup.get(), "data-plane-framework").versionRef("edc")
            library("dpf-http", edcGroup.get(), "data-plane-http").versionRef("edc")

            // SQL Stores
            library("sql-dataplane", edcGroup.get(), "data-plane-instance-store-sql").versionRef("edc")
            library("sql-asset", edcGroup.get(), "asset-index-sql").versionRef("edc")
            library("sql-policy", edcGroup.get(), "policy-definition-store-sql").versionRef("edc")
            library("sql-contract-negotiation", edcGroup.get(), "contract-negotiation-store-sql").versionRef("edc")
            library("sql-contract-definition", edcGroup.get(), "contract-definition-store-sql").versionRef("edc")
            library("sql-transfer-process", edcGroup.get(), "transfer-process-store-sql").versionRef("edc")

            bundle(
                "connector",
                listOf("boot", "core-connector", "core-jersey", "core-controlplane", "api-observability")
            )

            bundle(
                "dpf",
                listOf("dpf-core", "dpf-selector-core", "dpf-selector-client", "dpf-framework")
            )
        }
    }
}

include(":launchers:connector-local")
include(":launchers:connector-prod")

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

plugins {
    `java-library`
    id("application")
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

val groupId: String by project
val edcVersion: String by project
val sovityExtensionVersion: String by project



dependencies {
    runtimeOnly(edc.bundles.connector)
    runtimeOnly(edc.oauth2.core)
    runtimeOnly(edc.vault.filesystem)

    // Sovity EDC Extensions
    implementation("de.sovity.edc.ext:ids-broker-client:${sovityExtensionVersion}")
    implementation("de.sovity.edc.ext:ids-clearinghouse-client:${sovityExtensionVersion}")
    implementation("de.sovity.edc.ext:postgres-flyway:${sovityExtensionVersion}")

    implementation("$groupId:management-api:0.0.1-milestone-8")
    implementation("$groupId:http:0.0.1-milestone-8")

    // Data-plane
    implementation("$groupId:data-plane-http:${edcVersion}")
    implementation("$groupId:data-plane-framework:${edcVersion}")
    implementation("$groupId:data-plane-core:${edcVersion}")
    implementation("$groupId:data-plane-util:${edcVersion}")
}

application {
    mainClass.set("org.eclipse.edc.boot.system.runtime.BaseRuntime")
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    mergeServiceFiles()
    archiveFileName.set("connector-edc.jar")
}

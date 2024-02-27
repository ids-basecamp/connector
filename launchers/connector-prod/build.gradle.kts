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
 *       truzzt GmbH - Initial implementation
 *
 */

plugins {
    `java-library`
    id("application")
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

val sovityEDCVersion: String by project

dependencies {
    runtimeOnly(edc.bundles.connector)
    runtimeOnly(edc.ids)
    runtimeOnly(edc.ids.jsonld.serdes)
    runtimeOnly(edc.api.management)

    runtimeOnly(edc.bundles.dpf)
    runtimeOnly(edc.dpf.http)

    runtimeOnly(edc.sql.dataplane)
    runtimeOnly(edc.sql.asset)
    runtimeOnly(edc.sql.policy)
    runtimeOnly(edc.sql.contract.negotiation)
    runtimeOnly(edc.sql.contract.definition)
    runtimeOnly(edc.sql.transfer.process)

    runtimeOnly(edc.oauth2.core)
    runtimeOnly(edc.vault.filesystem)

    // Sovity EDC Extensions
    implementation("de.sovity.edc.ext:ids-broker-client:${sovityEDCVersion}")
    implementation("de.sovity.edc.ext:ids-clearinghouse-client:${sovityEDCVersion}")
    implementation("de.sovity.edc.ext:postgres-flyway:${sovityEDCVersion}")
}

application {
    mainClass.set("org.eclipse.edc.boot.system.runtime.BaseRuntime")
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    mergeServiceFiles()
    archiveFileName.set("connector-edc.jar")
}

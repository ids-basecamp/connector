package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `edc` extension.
 */
@NonNullApi
public class LibrariesForEdc extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ApiLibraryAccessors laccForApiLibraryAccessors = new ApiLibraryAccessors(owner);
    private final ConfigLibraryAccessors laccForConfigLibraryAccessors = new ConfigLibraryAccessors(owner);
    private final CoreLibraryAccessors laccForCoreLibraryAccessors = new CoreLibraryAccessors(owner);
    private final ExtLibraryAccessors laccForExtLibraryAccessors = new ExtLibraryAccessors(owner);
    private final IdsLibraryAccessors laccForIdsLibraryAccessors = new IdsLibraryAccessors(owner);
    private final Oauth2LibraryAccessors laccForOauth2LibraryAccessors = new Oauth2LibraryAccessors(owner);
    private final SpiLibraryAccessors laccForSpiLibraryAccessors = new SpiLibraryAccessors(owner);
    private final VaultLibraryAccessors laccForVaultLibraryAccessors = new VaultLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForEdc(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

        /**
         * Creates a dependency provider for boot (org.eclipse.edc:boot)
         * This dependency was declared in settings file 'settings.gradle.kts'
         */
        public Provider<MinimalExternalModuleDependency> getBoot() {
            return create("boot");
    }

        /**
         * Creates a dependency provider for junit (org.eclipse.edc:junit)
         * This dependency was declared in settings file 'settings.gradle.kts'
         */
        public Provider<MinimalExternalModuleDependency> getJunit() {
            return create("junit");
    }

        /**
         * Creates a dependency provider for util (org.eclipse.edc:util)
         * This dependency was declared in settings file 'settings.gradle.kts'
         */
        public Provider<MinimalExternalModuleDependency> getUtil() {
            return create("util");
    }

    /**
     * Returns the group of libraries at api
     */
    public ApiLibraryAccessors getApi() {
        return laccForApiLibraryAccessors;
    }

    /**
     * Returns the group of libraries at config
     */
    public ConfigLibraryAccessors getConfig() {
        return laccForConfigLibraryAccessors;
    }

    /**
     * Returns the group of libraries at core
     */
    public CoreLibraryAccessors getCore() {
        return laccForCoreLibraryAccessors;
    }

    /**
     * Returns the group of libraries at ext
     */
    public ExtLibraryAccessors getExt() {
        return laccForExtLibraryAccessors;
    }

    /**
     * Returns the group of libraries at ids
     */
    public IdsLibraryAccessors getIds() {
        return laccForIdsLibraryAccessors;
    }

    /**
     * Returns the group of libraries at oauth2
     */
    public Oauth2LibraryAccessors getOauth2() {
        return laccForOauth2LibraryAccessors;
    }

    /**
     * Returns the group of libraries at spi
     */
    public SpiLibraryAccessors getSpi() {
        return laccForSpiLibraryAccessors;
    }

    /**
     * Returns the group of libraries at vault
     */
    public VaultLibraryAccessors getVault() {
        return laccForVaultLibraryAccessors;
    }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class ApiLibraryAccessors extends SubDependencyFactory {
        private final ApiManagementLibraryAccessors laccForApiManagementLibraryAccessors = new ApiManagementLibraryAccessors(owner);

        public ApiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for observability (org.eclipse.edc:api-observability)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getObservability() {
                return create("api.observability");
        }

        /**
         * Returns the group of libraries at api.management
         */
        public ApiManagementLibraryAccessors getManagement() {
            return laccForApiManagementLibraryAccessors;
        }

    }

    public static class ApiManagementLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public ApiManagementLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for management (org.eclipse.edc:management-api)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("api.management");
        }

            /**
             * Creates a dependency provider for config (org.eclipse.edc:management-api-configuration)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getConfig() {
                return create("api.management.config");
        }

    }

    public static class ConfigLibraryAccessors extends SubDependencyFactory {

        public ConfigLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for filesystem (org.eclipse.edc:configuration-filesystem)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getFilesystem() {
                return create("config.filesystem");
        }

    }

    public static class CoreLibraryAccessors extends SubDependencyFactory {

        public CoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for connector (org.eclipse.edc:connector-core)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getConnector() {
                return create("core.connector");
        }

            /**
             * Creates a dependency provider for controlplane (org.eclipse.edc:control-plane-core)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getControlplane() {
                return create("core.controlplane");
        }

            /**
             * Creates a dependency provider for jersey (org.eclipse.edc:jersey-core)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getJersey() {
                return create("core.jersey");
        }

            /**
             * Creates a dependency provider for jetty (org.eclipse.edc:jetty-core)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getJetty() {
                return create("core.jetty");
        }

    }

    public static class ExtLibraryAccessors extends SubDependencyFactory {

        public ExtLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for http (org.eclipse.edc:http)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getHttp() {
                return create("ext.http");
        }

    }

    public static class IdsLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final IdsJsonldLibraryAccessors laccForIdsJsonldLibraryAccessors = new IdsJsonldLibraryAccessors(owner);

        public IdsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ids (org.eclipse.edc:ids)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("ids");
        }

        /**
         * Returns the group of libraries at ids.jsonld
         */
        public IdsJsonldLibraryAccessors getJsonld() {
            return laccForIdsJsonldLibraryAccessors;
        }

    }

    public static class IdsJsonldLibraryAccessors extends SubDependencyFactory {

        public IdsJsonldLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for serdes (org.eclipse.edc:ids-jsonld-serdes)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getSerdes() {
                return create("ids.jsonld.serdes");
        }

    }

    public static class Oauth2LibraryAccessors extends SubDependencyFactory {

        public Oauth2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (org.eclipse.edc:oauth2-core)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("oauth2.core");
        }

    }

    public static class SpiLibraryAccessors extends SubDependencyFactory {

        public SpiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for catalog (org.eclipse.edc:catalog-spi)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getCatalog() {
                return create("spi.catalog");
        }

            /**
             * Creates a dependency provider for core (org.eclipse.edc:core-spi)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("spi.core");
        }

            /**
             * Creates a dependency provider for ids (org.eclipse.edc:ids-spi)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getIds() {
                return create("spi.ids");
        }

            /**
             * Creates a dependency provider for web (org.eclipse.edc:web-spi)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getWeb() {
                return create("spi.web");
        }

    }

    public static class VaultLibraryAccessors extends SubDependencyFactory {

        public VaultLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for filesystem (org.eclipse.edc:vault-filesystem)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getFilesystem() {
                return create("vault.filesystem");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: edc (1.0.3-basecamp)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in settings file 'settings.gradle.kts'
             */
            public Provider<String> getEdc() { return getVersion("edc"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

            /**
             * Creates a dependency bundle provider for connector which is an aggregate for the following dependencies:
             * <ul>
             *    <li>org.eclipse.edc:boot</li>
             *    <li>org.eclipse.edc:connector-core</li>
             *    <li>org.eclipse.edc:jersey-core</li>
             *    <li>org.eclipse.edc:control-plane-core</li>
             *    <li>org.eclipse.edc:api-observability</li>
             * </ul>
             * This bundle was declared in settings file 'settings.gradle.kts'
             */
            public Provider<ExternalModuleDependencyBundle> getConnector() {
                return createBundle("connector");
            }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}

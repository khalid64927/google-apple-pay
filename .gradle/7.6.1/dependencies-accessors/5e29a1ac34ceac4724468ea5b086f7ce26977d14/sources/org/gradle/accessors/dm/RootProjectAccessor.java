package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.ProjectDependency;
import org.gradle.api.internal.artifacts.dependencies.ProjectDependencyInternal;
import org.gradle.api.internal.artifacts.DefaultProjectDependencyFactory;
import org.gradle.api.internal.artifacts.dsl.dependencies.ProjectFinder;
import org.gradle.api.internal.catalog.DelegatingProjectDependency;
import org.gradle.api.internal.catalog.TypeSafeProjectDependencyFactory;
import javax.inject.Inject;

@NonNullApi
public class RootProjectAccessor extends TypeSafeProjectDependencyFactory {


    @Inject
    public RootProjectAccessor(DefaultProjectDependencyFactory factory, ProjectFinder finder) {
        super(factory, finder);
    }

    /**
     * Creates a project dependency on the project at path ":"
     */
    public GoogleApplePayProjectDependency getGoogleApplePay() { return new GoogleApplePayProjectDependency(getFactory(), create(":")); }

    /**
     * Creates a project dependency on the project at path ":google-apple-pay"
     */
    public GoogleApplePayProjectDependency getGoogleApplePay() { return new GoogleApplePayProjectDependency(getFactory(), create(":google-apple-pay")); }

    /**
     * Creates a project dependency on the project at path ":permissions"
     */
    public PermissionsProjectDependency getPermissions() { return new PermissionsProjectDependency(getFactory(), create(":permissions")); }

    /**
     * Creates a project dependency on the project at path ":permissions-compose"
     */
    public PermissionsComposeProjectDependency getPermissionsCompose() { return new PermissionsComposeProjectDependency(getFactory(), create(":permissions-compose")); }

    /**
     * Creates a project dependency on the project at path ":permissions-test"
     */
    public PermissionsTestProjectDependency getPermissionsTest() { return new PermissionsTestProjectDependency(getFactory(), create(":permissions-test")); }

    /**
     * Creates a project dependency on the project at path ":sample"
     */
    public SampleProjectDependency getSample() { return new SampleProjectDependency(getFactory(), create(":sample")); }

}

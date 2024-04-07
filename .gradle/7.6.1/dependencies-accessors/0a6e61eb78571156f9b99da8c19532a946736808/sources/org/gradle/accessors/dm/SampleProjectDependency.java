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
public class SampleProjectDependency extends DelegatingProjectDependency {

    @Inject
    public SampleProjectDependency(TypeSafeProjectDependencyFactory factory, ProjectDependencyInternal delegate) {
        super(factory, delegate);
    }

    /**
     * Creates a project dependency on the project at path ":sample:android-app"
     */
    public Sample_AndroidAppProjectDependency getAndroidApp() { return new Sample_AndroidAppProjectDependency(getFactory(), create(":sample:android-app")); }

    /**
     * Creates a project dependency on the project at path ":sample:compose-android-app"
     */
    public Sample_ComposeAndroidAppProjectDependency getComposeAndroidApp() { return new Sample_ComposeAndroidAppProjectDependency(getFactory(), create(":sample:compose-android-app")); }

    /**
     * Creates a project dependency on the project at path ":sample:mpp-library"
     */
    public Sample_MppLibraryProjectDependency getMppLibrary() { return new Sample_MppLibraryProjectDependency(getFactory(), create(":sample:mpp-library")); }

}

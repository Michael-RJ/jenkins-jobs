package ci_open_jenkins.build
import javaposse.jobdsl.dsl.DslFactory
import uk.gov.hmrc.jenkinsjobbuilders.domain.builder.BuildMonitorViewBuilder
import uk.gov.hmrc.jenkinsjobs.domain.builder.SbtMicroserviceJobBuilder

new SbtMicroserviceJobBuilder('individuals-api').
        withTests("test it:test component:test").
        build(this as DslFactory)

new SbtMicroserviceJobBuilder('itmp-individual-details-stub').
        withTests("test it:test component:test").
        build(this as DslFactory)

new BuildMonitorViewBuilder('IVHO-MONITOR')
        .withJobs(
        'individuals-api',
        'itmp-individual-details-stub'
).build(this)

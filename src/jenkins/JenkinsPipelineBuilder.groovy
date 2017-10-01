package jenkins

def pipelineSteps;

// Constructor, called from PipelineBootstrap.createBuilder().
void initialize() {
    echo 'Initializing PipelineBuilder.'
    pipelineSteps = new JenkinsPipelineSteps()
    pipelineSteps.initialize();
}

def getPipelineSteps() {
    return pipelineSteps
}

void clone(String project) {
    pipelineSteps.clone(project)
}

return this;

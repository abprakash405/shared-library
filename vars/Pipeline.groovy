#!/usr/bin/env groovy

def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    def sample = new Sample()
    
    Sample()
    echo config.name
    
    
}

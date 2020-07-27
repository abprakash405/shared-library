#!/usr/bin/env groovy

def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    new Sample(script:this).run()
    echo config.name
    echo config.rollno
    
    
    
}

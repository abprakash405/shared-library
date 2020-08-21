#!/usr/bin/env groovy

def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    new Sample(script:this).code()
    new Sample(script:this).build()
    new Sample(script:this).deploy()
    echo config.name
    echo config.rollno
    
    
    
}

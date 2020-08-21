public class Sample {
	int a = 1
	int b = 2
	Script script 
	def code() {
		script.echo("Cloud DevOps training course from AspireNew Technologies")
		sh("echo 'code stage' ")
	}
	def build() {
		script.echo("Cloud DevOps training course from AspireNew Technologies")
		sh("echo 'build stage' ")
	}
	def deploy() {
		script.echo("Cloud DevOps training course from AspireNew Technologies")
		sh("echo 'deploy stage' ")
	}
}

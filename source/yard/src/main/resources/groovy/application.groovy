
beans {

	groovyPojo(com.doc.spring.groovy.GroovyPojo){
		name="Groovy pojo name"
	}
	
	GroovyEmbeddedPojo(com.doc.spring.groovy.GroovyEmbeddedPojo){
		name="Groovy pojo embedded name"
		groobyPojo = groovyPojo
	}
	
}
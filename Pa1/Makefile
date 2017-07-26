# Makefile for pa1 

JAVASRC		= List.java Node.java UndefinedCursorException.java Lex.java ListClient.java
SOURCES		= makefile $(JAVASRC)
MAINCLASS	= ListClient
CLASSES		= List.class Node.class UndefinedCursorExceptio.java Lex.class ListClient.java 
JARFILE		= Lex

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest

$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)

clean:
	rm $(CLASSES) $(JARFILE)

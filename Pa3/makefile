# Makefile for pa3 CMPS101
#
# Compiles all .java files in current directory and creates executable jar file called Sparse.

MAINCLASS	= Sparse
JAVAC		= javac
JAVASRC		= $(wildcard *java)
SOURCES		= $(JAVASRC) makefile README
CLASSES		= $(patsubst %.java, %.class, $(JAVASRC))
JARCLASSES	= $(patsubst %.class, %*.class, $(CLASSES))
JARFILE		= $(MAINCLASS)

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(JARCLASSES)
	chmod +x $(JARFILE)
	rm Manifest

%.class: %.java
	$(JAVAC) $<

clean:
	rm -f *.class $(JARFILE)

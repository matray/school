JAVAC=javac
sources = $(wildcard *.java)
classes = $(sources:.java=.class)

all: $(classes)

clean:
	rm -rf *.class

%.class : %.java
	$(JAVAC) $<

run:
	java Blackjack

package:
	jar cf Blackjack.jar *.class

pack_run:
	java -jar Blackjack.jar

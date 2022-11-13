CC=gcc
LEX=flex

pythonlexer: pythonlexer.o
pythonlexer.o: pythonlexer.l

test: pythonlexer
	./pythonlexer example-01.py

clean:
	rm -f pythonlexer *.o
import graphviz
file=open('./AST',mode='r')
source=file.read()
file.close()
graphviz.Source(source,filename='AST').view() #Render the AST
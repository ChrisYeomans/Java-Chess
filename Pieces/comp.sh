echo "Compiling Piece.java"
javac -d . Piece.java

for fle in $(ls | grep .java)
do
	if [ "$fle" != "Piece.java" ]
	then
		echo "Compiling $fle"
		javac -d . $fle
	fi
done
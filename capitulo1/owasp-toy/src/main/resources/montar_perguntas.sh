gerar_rand(){
  maximo=$1
  resultado=$( cat /dev/urandom | tr -dc '1-9' | fold -w 10000 | head -n 1 )
  resultado=$((resultado%maximo+1)) 
  echo $resultado | sed -e 's/-//'

}

function gerarPergunta(){
    start_line=$( gerar_rand 90 )
    end_offset=$( gerar_rand 2 )


    total_linhas=$( cat lorem.txt | tr '\n' ' ' | tr -cd . | wc -c )

    end_line=$((start_line+end_offset+1))

    fields=$( seq $start_line $end_line | tr '\n' ',' | sed -e 's/,$//' )


    echo "$( cat lorem.txt | sed 's/\n/. /' | cut -d '.' -f $fields | sed -e 's/\.$//' -e 's/\s*$//' -e 's/^\s*//' )?"

}

function gerar_perguntas(){

    if [ -e perguntas.sql ]
    then
        rm perguntas.sql
    fi

    maximo_usuario=$( cat usuarios.sql | wc -l )
    maximo_usuario=$((maximo_usuario%400))

    for i in $( seq 1 50 )
    do
      echo $i 

      echo "insert into perguntas ( pergunta, usuario_id ) values ('$( gerarPergunta )',$( gerar_rand $maximo_usuario ));" >> perguntas.sql

    done
}

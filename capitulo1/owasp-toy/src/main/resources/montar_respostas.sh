gerar_rand(){
  maximo=$1
  resultado=$( cat /dev/urandom | tr -dc '1-9' | fold -w 10000 | head -n 1 )
  resultado=$((resultado%maximo+1)) 
  echo $resultado | sed -e 's/-//'

}

function gerarPergunta(){
    start_line=$( gerar_rand 90 )
    end_offset=$( gerar_rand 10 )


    total_linhas=$( cat lorem.txt | tr '\n' ' ' | tr -cd . | wc -c )

    end_line=$((start_line+end_offset+1))


    fields=$( seq $start_line $end_line | tr '\n' ',' | sed -e 's/,$//' )


    echo "$( cat lorem.txt | sed 's/\n/. /' | cut -d '.' -f $fields | sed -e 's/\.$//' -e 's/\s*$//' -e 's/^\s*//' )?"

}

function gerar_respostas(){

    if [ -e respostas.sql ]
    then
        rm respostas.sql
    fi


    for i in $( seq 1 500 )
    do
      echo $i 

      numero_resposta=$(gerar_rand 18)
      numero_resposta=$((numero_resposta+30))

      echo "insert into respostas ( resposta, pergunta_id, usuario_id ) values ('$( gerarPergunta )',$numero_resposta,$( gerar_rand 500 ));" >> respostas.sql

    done

}

function gerar_usuarios(){
    rm usuarios.sql

    echo "" > usuarios.sql

    total=1000
    cont=0
    for usuario in $( tail -n 1000 usernames.txt )
    do
        deveInserir=$( cat /dev/urandom | tr -dc '0-9' | fold -w 2 | head -n 1 )

        if [ $deveInserir -gt 50 ]
        then


            possibilidade=$( cat /dev/urandom | tr -dc '0-9' | fold -w 2 | head -n 1 )

            password=$( cat /dev/urandom | tr -dc 'A-Za-z0-9'| fold -w 10 | head -n 1 )

            if [ $possibilidade -lt 30 ]
            then
              echo "password falho"
              password=$( shuf -n 1 passwords.txt ) 
            fi

            possibilidade=$( cat /dev/urandom | tr -dc '0-9' | fold -w 2 | head -n 1 )

            if [ $possibilidade -lt 60 ]
            then
                sufixo=$( cat /dev/urandom | tr -dc 'A-Za-z0-9'| fold -w 10 | head -n 1 )
                usuario=$usuario.$sufixo
            else 
                echo "usuario falho"
            fi

            echo "insert into usuarios (usuario,senha,email) values  ( '$usuario', '$password','$usuario@some.email.com' );">> usuarios.sql
        fi

        let "cont = $cont +1 "

        echo "$cont / $total "
    done
}

source gerarUsuarios.sh
source montar_perguntas.sh
source montar_respostas.sh

gerar_usuarios
gerar_perguntas
gerar_respostas


if [ -e data.sql ]
then
    rm data.sql
fi

cat usuarios.sql > data.sql
cat perguntas.sql >> data.sql
cat respostas.sql >> data.sql


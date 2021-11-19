echo "Criando tabela Games..."
awslocal dynamodb create-table --cli-input-json file://tables/game_table.json --endpoint-url=http://localhost:4566
echo "Tabela criada com sucesso"
awslocal dynamodb describe-table --table-name Games | grep TableStatus
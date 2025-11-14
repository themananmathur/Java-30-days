# !/bin/sh
# wait-for-db.sh
set -e

host="$1"
shift
cmd="$@"

echo "Waiting for MySQL at $host ..."

# try mysql ping until success
until mysqladmin ping -h "$host" --silent; do
  >&2 echo "MySQL is unavailable - sleeping 2s"
  sleep 2
done

>&2 echo "MySQL is up - executing command"
exec $cmd

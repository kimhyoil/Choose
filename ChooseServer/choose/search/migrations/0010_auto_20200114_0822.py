# Generated by Django 3.0.2 on 2020-01-14 08:22

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('search', '0009_auto_20200114_0746'),
    ]

    operations = [
        migrations.AlterField(
            model_name='usercard',
            name='card_cvc',
            field=models.CharField(max_length=3),
        ),
        migrations.AlterField(
            model_name='usercard',
            name='card_num',
            field=models.CharField(max_length=19),
        ),
        migrations.AlterField(
            model_name='usercard',
            name='card_validate_num',
            field=models.CharField(max_length=5),
        ),
    ]

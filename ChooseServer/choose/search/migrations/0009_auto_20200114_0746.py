# Generated by Django 3.0.2 on 2020-01-14 07:46

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('search', '0008_usercard'),
    ]

    operations = [
        migrations.RenameField(
            model_name='usercard',
            old_name='uesr',
            new_name='user',
        ),
        migrations.AlterField(
            model_name='usercard',
            name='card_cvc',
            field=models.IntegerField(),
        ),
    ]